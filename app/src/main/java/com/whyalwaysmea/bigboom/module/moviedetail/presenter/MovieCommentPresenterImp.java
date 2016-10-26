package com.whyalwaysmea.bigboom.module.moviedetail.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Comment;
import com.whyalwaysmea.bigboom.module.moviedetail.model.MovieCommentModelImp;
import com.whyalwaysmea.bigboom.module.moviedetail.view.IMovieCommentView;

/**
 * Created by Long
 * on 2016/10/26.
 */

public class MovieCommentPresenterImp extends BasePresenter<IMovieCommentView> implements IMovieCommentPresenter, OnLoadCompleteListener<Comment> {

    private MovieCommentModelImp mCommentModel;

    public MovieCommentPresenterImp(IMovieCommentView iMovieCommentView) {
        super(iMovieCommentView);
        mCommentModel = new MovieCommentModelImp();
    }

    @Override
    public void getComment(String id) {
        mCommentModel.loadMovieComments(id, this);
    }

    @Override
    public void onLoadSussess(Comment comment) {
        mView.hideLoading();
        mView.setComment(comment.getComments());
    }

    @Override
    public void onLoadFailed(String error) {
        mView.hideLoading();
        mView.showToast(error);
    }
}
