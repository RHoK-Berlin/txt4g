class FeedsController < ApplicationController
  before_filter :authenticate_user!

  def index
    @feeds = Feed.page(params[:page])
  end

  def new
    @feed = Feed.new
  end

  def create
    @feed = Feed.new params[:feed]
    if @feed.save
      flash[:success] = "Saved"
      redirect_to @feed
    else
      flash[:error] = 'Could not save'
      render :new
    end
  end

  def show
    @feed = Feed.find params[:id]
  end

  def edit
    @feed = Feed.find params[:id]
  end

  def update
    @feed = Feed.find params[:id]
    if @feed.update_attributes params[:feed]
      flash[:success] = "Saved"
      redirect_to @feed
    else
      flash[:error] = 'Could not save'
      render :edit
    end
  end

end
