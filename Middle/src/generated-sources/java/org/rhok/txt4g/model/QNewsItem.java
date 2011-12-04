package org.rhok.txt4g.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QNewsItem is a Querydsl query type for NewsItem
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QNewsItem extends EntityPathBase<NewsItem> {

    private static final long serialVersionUID = -1955233464;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QNewsItem newsItem = new QNewsItem("newsItem");

    public final org.bson.types.QObjectId id;

    public final StringPath text = createString("text");

    public QNewsItem(String variable) {
        this(NewsItem.class, forVariable(variable), INITS);
    }

    public QNewsItem(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsItem(PathMetadata<?> metadata, PathInits inits) {
        this(NewsItem.class, metadata, inits);
    }

    public QNewsItem(Class<? extends NewsItem> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

