package org.bson.types;


import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QObjectId is a Querydsl query type for ObjectId
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QObjectId extends BeanPath<ObjectId> {

    private static final long serialVersionUID = 1931139171;

    public final NumberPath<Integer> _inc = createNumber("_inc", Integer.class);

    public final NumberPath<Integer> _machine = createNumber("_machine", Integer.class);

    public final BooleanPath _new = createBoolean("_new");

    public final NumberPath<Integer> _time = createNumber("_time", Integer.class);

    public final NumberPath<Integer> inc = createNumber("inc", Integer.class);

    public final NumberPath<Integer> machine = createNumber("machine", Integer.class);

    public final BooleanPath new$ = createBoolean("new");

    public final NumberPath<Long> time = createNumber("time", Long.class);

    public final NumberPath<Integer> timeSecond = createNumber("timeSecond", Integer.class);

    public QObjectId(BeanPath<? extends ObjectId> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QObjectId(PathMetadata<?> metadata) {
        super(ObjectId.class, metadata);
    }

}

