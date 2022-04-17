package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.events.targets.SnsTopic;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.EmailSubscription;
import software.constructs.Construct;
// import software.amazon.awscdk.Duration;
// import software.amazon.awscdk.services.sqs.Queue;

public class SnsStack extends Stack {
    private SnsTopic productEventsTopic;

    public SnsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public SnsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        productEventsTopic = SnsTopic.Builder.create(
                        Topic.Builder.create(this, "ProductEventsTopic")
                                .topicName("product-events")
                                .build())
                .build();

        productEventsTopic.getTopic().addSubscription(EmailSubscription.Builder.create("lelis685+curso@gmail.com")
                .json(true)
                .build());



    }

    public SnsTopic getProductEventsTopic() {
        return productEventsTopic;
    }
}
