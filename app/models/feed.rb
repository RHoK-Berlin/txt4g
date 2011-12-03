class Feed
  include Mongoid::Document

  field :name
  has_many :news_items

  validates_presence_of :name
end
