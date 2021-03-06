/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.core.event.transaction.base;

import io.shardingsphere.core.constant.transaction.TransactionOperationType;
import io.shardingsphere.core.event.transaction.ShardingTransactionEvent;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;

/**
 * Saga transaction event.
 *
 * @author yangyi
 */
@Getter
public class SagaTransactionEvent implements ShardingTransactionEvent {
    
    private final TransactionOperationType operationType;
    
    private final Connection connection;
    
    private final String proxySchema;
    
    @Setter
    private String sagaJson;
    
    public SagaTransactionEvent(final TransactionOperationType operationType) {
        this.operationType = operationType;
        this.connection = null;
        this.proxySchema = null;
    }
    
    public SagaTransactionEvent(final TransactionOperationType operationType, final Connection connection) {
        this.operationType = operationType;
        this.connection = connection;
        this.proxySchema = null;
    }
    
    public SagaTransactionEvent(final TransactionOperationType operationType, final String proxySchema) {
        this.operationType = operationType;
        this.connection = null;
        this.proxySchema = proxySchema;
    }
}
