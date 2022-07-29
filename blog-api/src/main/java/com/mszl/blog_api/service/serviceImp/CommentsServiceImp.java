package com.mszl.blog_api.service.serviceImp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mszl.blog_api.Utils.UserThreadLocal;
import com.mszl.blog_api.dao.mapper.CommentsMapper;
import com.mszl.blog_api.dao.pojo.Comments;
import com.mszl.blog_api.dao.pojo.SysUser;
import com.mszl.blog_api.service.CommentsService;
import com.mszl.blog_api.service.SysUserService;
import com.mszl.blog_api.vo.CommentVo;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.UserVo;
import com.mszl.blog_api.vo.params.CommentParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServiceImp implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 1、根据文章id 查询评论列表 从comments表中查询
     * 2、根据作者id 查询作者信息
     * 3、level = 1 查询子评论
     * 有就查询查子评论
     */
    @Override
    public Result commentsByArticleId(Long id) {
        LambdaQueryWrapper<Comments> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comments::getId, id);
        queryWrapper.eq(Comments::getLevel, 1);
        List<Comments> comments = commentsMapper.selectList(queryWrapper);
        List<CommentVo> commentVos = copyList(comments);
        return Result.success(commentVos);
    }

    @Override
    public Result comment(CommentParam commentParam) {
        SysUser sysUser = UserThreadLocal.get();
        Comments comments = new Comments();
        comments.setArticleId(commentParam.getArticleId());
        comments.setId(sysUser.getId());
        comments.setContent(commentParam.getContent());
        comments.setCreateDate(System.currentTimeMillis());
        Long parent = commentParam.getParent();
        if (parent == null || parent == 0) {
            comments.setLevel(1);
        } else {
            comments.setLevel(2);
        }
        comments.setParentId(parent == null ? 0 : parent);
        Long toUserId = commentParam.getToUserId();
        comments.setToUid(toUserId == null ? 0 : toUserId);
        this.commentsMapper.insert(comments);
        return Result.success(null);
    }

    private List<CommentVo> copyList(List<Comments> comments) {
        List<CommentVo> commentVos = new ArrayList<>();
        for (Comments comment : comments) {
            commentVos.add(copy(comment));
        }
        return commentVos;
    }

    private CommentVo copy(Comments comment) {
        CommentVo commentVo = new CommentVo();
        BeanUtils.copyProperties(comment, commentVo);
        Long authorId = comment.getAuthorId();
        UserVo userVo = sysUserService.findUserVoById(authorId);
        commentVo.setAuthor(userVo);
        //子评论
        Integer level = commentVo.getLevel();
        if (level == 1) {
            Long id = comment.getId();
            List<CommentVo> commentVos = findCommentsByParentId(id);
            commentVo.setChildren(commentVos);
        }
        //to User
        if (level > 1) {
            Long toUid = comment.getToUid();
            UserVo toUserVo = this.sysUserService.findUserVoById(toUid);
            commentVo.setToUser(toUserVo);
        }
        return commentVo;
    }

    private List<CommentVo> findCommentsByParentId(Long id) {
        LambdaQueryWrapper<Comments> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Comments::getParentId, id);
        queryWrapper.eq(Comments::getLevel, 2);
        return copyList(commentsMapper.selectList(queryWrapper));
    }
}
