/**
 * Copyright 2016 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.pulsar.client.impl;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class ConsumerId implements Comparable<ConsumerId> {
    private final String topic;
    private final String subscription;

    public ConsumerId(String topic, String subscription) {
        this.topic = topic;
        this.subscription = subscription;
    }

    public String getTopic() {
        return topic;
    }

    public String getSubscription() {
        return subscription;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(topic, subscription);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConsumerId) {
            ConsumerId other = (ConsumerId) obj;
            return Objects.equal(this.topic, other.topic) && Objects.equal(this.subscription, other.subscription);
        }

        return false;
    }

    @Override
    public int compareTo(ConsumerId o) {
        return ComparisonChain.start().compare(this.topic, o.topic).compare(this.subscription, o.subscription).result();
    }

}
