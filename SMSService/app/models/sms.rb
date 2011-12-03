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
    raise AuthError.new("No user and/or password given!") if user.blank? || pw.blank?

    base_url = "http://www.smsout.de/client/sendsms.php"
    response = Typhoeus::Request.get(
      base_url,
      params: { :Username => user, :Password => pw, :SMSTo => to, :SMSType => :V1, :SMSText => body}
    )
    raise AuthError.new("Invalid credentials!") if response.body.include?('ErrorCode: 9997')
    response
  end
end
