class NewsItemsController < ApplicationController
  before_filter :authenticate_user!
  before_filter :load_feed

  def index
    @news_items = @feed.news_items.desc(:created_at).page(params[:page])
  end

  def new
    @news_item = @feed.news_items.new
  end

  def create
    @news_item = @feed.news_items.new params[:news_item]
    if @news_item.save
      flash[:success] = "Saved"
      redirect_to feed_news_items_path(@feed)
    else
      flash[:error] = 'Could not save'
      render :new
    end
  end

  private
  def load_feed
    @feed = Feed.find params[:feed_id]
  end
end
