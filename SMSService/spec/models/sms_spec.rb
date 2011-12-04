require 'spec_helper'

describe Sms do

  let(:from) { '123' }
  let(:to) { '123' }
  let(:body) { 'hello world!' }
  let(:transmitter) { :twilio }

  describe ".new" do

    context "when no params are provided" do

      specify { Sms.new.should be }

    end

    context "when from is provided" do

      let(:sms) { Sms.new(from: from) }

      specify { sms.from.should be }

    end

    context "when to is provided" do

      let(:sms) { Sms.new(to: to) }

      specify { sms.to.should be }

    end

    context "when body is provided" do

      let(:sms) { Sms.new(body: body) }

      specify { sms.body.should be }

    end

  end

  describe "#transmit" do

    let(:sms) { Sms.new(from: from, to: to, body: body) }

    context "when invalid credentials are given" do

      before do
        sms.user = 'INVALID'
        sms.pw = 'INVALID'
        response = Typhoeus::Response.new(:code => 200, body: "Return: ERROR\r\nErrorCode: 9997\r\nErrorText: Benutzername und/oder Passwort inkorrekt.\r\n\r\n")
        Typhoeus::Request.stubs(:get).returns(response)
      end

      specify do 
        expect { sms.transmit }.to raise_error(Sms::AuthError, 'Invalid credentials!') 
      end

    end

    context "when valid credentials are given" do

      before do
        sms.user = ENV['RHOK_SMS_USERNAME']
        sms.pw = ENV['RHOK_SMS_PASSWORD']        
        response = Typhoeus::Response.new(:code => 200, body: "")
        Typhoeus::Request.stubs(:get).returns(response)
      end

      specify do
        sms.transmit.code.should eq(200) 
      end

    end

  end

end
