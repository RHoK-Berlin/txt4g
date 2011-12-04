class Feed
  include Mongoid::Document

  field :name
  field :sms_identifier
  has_many :news_items

  validates_presence_of :name
  validates_uniqueness_of :sms_identifier, :allow_nil => true
end
