class UsersController < ApplicationController
  before_filter :authenticate_user!

  def index
    @users = User.page(params[:page])
  end

  def new
    @user = User.new
  end

  def create
    @user = User.new params[:user]
    if @user.save
      flash[:success] = "Saved"
      redirect_to edit_user_path(@user)
    else
      flash[:error] = 'Could not save'
      render :new
    end
  end

  def edit
    @user = User.find params[:id]
  end

  def update
    @user = User.find params[:id]
    if params[:user][:password].blank?
      params[:user].delete(:password)
      params[:user].delete(:password_confirmation) if params[:user][:password_confirmation].blank?
    end
    if @user.update_attributes params[:user]
      flash[:success] = "Saved"
      redirect_to edit_user_path(@user)
    else
      flash[:error] = 'Could not save'
      render :edit
    end
  end
end
