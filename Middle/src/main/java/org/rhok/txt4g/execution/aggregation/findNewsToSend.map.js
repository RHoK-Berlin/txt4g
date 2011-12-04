function () {
    for (var feedIndex = 0; feedIndex < this.Feed.length; feedIndex++) {
    	for (var newsIndex = 0; newsIndex < this.Feed[feedIndex]; newsIndex++) {
    		emit(this.Feed[feedIndex].newsitems[newsIndex].newsID, this.phone);
    	}
    }
}