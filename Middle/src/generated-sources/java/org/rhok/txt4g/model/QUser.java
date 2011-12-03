package org.rhok.txt4g.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1909176947;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QUser user = new QUser("user");

    public final org.bson.types.QObjectId id;

    public final StringPath phoneNumber = createString("phoneNumber");

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

