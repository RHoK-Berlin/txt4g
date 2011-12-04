require 'typhoeus'

class Sms
  attr_accessor :from, :to, :body, :user, :pw

  class AuthError < StandardError; end

  def initialize(options = {})
    @from = options[:from]
    @to = options[:to]
    @body = options[:body]
    @user = options[:user] || ENV['RHOK_SMS_USERNAME']
    @pw = options[:pw] || ENV['RHOK_SMS_PASSWORD']
  end

  def transmit    
    if SERVICE_CONFIG['default_sms_service'] == 'smsout'
      base_url = SERVICE_CONFIG['smsout_base_url']
      params = { :Username => @user,
                 :Password => @pw,
                 :SMSType => SERVICE_CONFIG['smsout_smstype'],
                 :SMSTo => to,
                 :SMSText => body }
      response = Typhoeus::Request.get(base_url, params: params)
      if response.body.include?('ErrorCode: 9997')
        raise AuthError.new("Invalid credentials!")
      end
      return response
    # elsif SERVICE_CONFIG['default_sms_service'] == 'twilio'
    # add another service of your choice
    end
  end
end
