require 'rubygems'
require 'spork'

ENV["RAILS_ENV"] ||= 'test'

Spork.prefork do
  require File.expand_path("../../config/environment", __FILE__)
  require 'rspec/rails'
  require 'capybara/rspec'
  Dir[Rails.root.join("spec/support/**/*.rb")].each {|f| require f}
end

Spork.each_run do
  RSpec.configure do |config|
    config.mock_with :mocha
    config.include(Spec::Support::DefaultParams, :type => :controller)
  end
end
