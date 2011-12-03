RSpec.configure do |config|
  config.include Devise::TestHelpers, :type => :controller
end

module CapybaraDeviseHelpers

  def log_in(options = {})
    options[:email] ||= 'user@test.com'
    options[:password] ||= 'please'
    visit new_user_session_path
    fill_in 'Email', :with => options[:email]
    fill_in 'Password', :with => options[:password]
    click_button 'Sign in'
  end

end

RSpec.configure do |config|
  config.include CapybaraDeviseHelpers, :type => :request
end
