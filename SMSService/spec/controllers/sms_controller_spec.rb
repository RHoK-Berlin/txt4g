require 'spec_helper'

describe SmsController do

  let(:from) { '123' }
  let(:to) { '123' }
  let(:body) { 'hello world!' }
  
  describe "#send_sms" do
    context "when no parameters are given" do
      before do
        post :send_sms
      end
  
      it "should return 400" do
        response.code.should eq("400")
      end  
    end
    
    context "when valid parameters are given" do
      before do
        response = Typhoeus::Response.new(:code => 200, body: "")
        hydra = Typhoeus::Hydra.hydra
        hydra.stub(:get, 
          "http://www.smsout.de/client/sendsms.php").and_return(response)

        post :send_sms, sms: { from: from, to: to, body: body }
      end

      it "should return 200" do
        response.code.should eq("200")
      end
    end
  end
  
end
