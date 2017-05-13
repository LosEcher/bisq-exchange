/*
 * This file is part of bisq.
 *
 * bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bisq.core.btc.data;

import com.google.protobuf.ByteString;
import io.bisq.common.network.NetworkPayload;
import io.bisq.common.persistable.PersistablePayload;
import io.bisq.generated.protobuffer.PB;
import lombok.EqualsAndHashCode;
import org.bouncycastle.util.encoders.Hex;

import javax.annotation.concurrent.Immutable;

@EqualsAndHashCode
@Immutable
public final class RawTransactionInput implements NetworkPayload, PersistablePayload {
    // Payload
    public final long index;
    public final byte[] parentTransaction;
    public final long value;

    public RawTransactionInput(long index, byte[] parentTransaction, long value) {
        this.index = index;
        this.parentTransaction = parentTransaction;
        this.value = value;
    }

    // byes not printed...
    @Override
    public String toString() {
        return "RawTransactionInput{" +
                "index=" + index +
                ", parentTransaction as HEX " + Hex.toHexString(parentTransaction) +
                ", value=" + value +
                '}';
    }

    @Override
    public PB.RawTransactionInput toProtoMessage() {
        return PB.RawTransactionInput.newBuilder()
                .setIndex(index)
                .setParentTransaction(ByteString.copyFrom(parentTransaction))
                .setValue(value).build();
    }
}