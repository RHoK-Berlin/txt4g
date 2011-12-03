class SmsController < ApplicationController

  expose(:sms) do
    Sms.new(params[:sms]) if params[:sms]
  end

  def send_sms
    if sms
      sms.transmit
      render nothing: true
    else
      render nothing: true, status: 400
    end
  end
  
  def recv_sms
    if sms
      logger.debug "notify that we received a sms"
    end
    
    redirect_to :back
  end

end
