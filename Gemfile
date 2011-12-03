require 'rbconfig'
HOST_OS = RbConfig::CONFIG['host_os']
source 'http://rubygems.org'
gem 'rails', '3.1.3'
group :assets do
  gem 'sass-rails',   '~> 3.1.5'
  gem 'coffee-rails', '~> 3.1.1'
  gem 'uglifier', '>= 1.0.3'
end
if HOST_OS =~ /linux/i
  gem 'therubyracer', '>= 0.9.8'
end
gem "rspec-rails", ">= 2.8.0.rc1", :group => [:development, :test]
gem "database_cleaner", ">= 0.7.0", :group => :test
gem "mongoid-rspec", ">= 1.4.4", :group => :test
gem "bson_ext", ">= 1.3.1"
gem "mongoid", ">= 2.3.3"
gem "devise", ">= 1.5.0"
gem "twitter-bootstrap-rails"
gem 'kaminari'

group :test do
  gem 'launchy'
  gem 'capybara'
  gem 'factory_girl_rails'
end
