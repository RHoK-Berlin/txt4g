class NewsItem
  include Mongoid::Document

  field :text
  belongs_to :feed

  validates_presence_of :feed_id, :text
end
