require 'factory_girl'

Factory.define :user do |u|
  u.email 'user@test.com'
  u.password 'please'
  u.password_confirmation { password }
end

Factory.define :feed do |f|
  f.name "Malaria"
end

