/**
 * Copyright 2012 Emmanuel Bourg
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

package net.jsign.asn1.authenticode;

import org.bouncycastle.asn1.*;

/**
 * <pre>
 * SpcStatementType ::= SEQUENCE of OBJECT IDENTIFIER
 * </pre>
 * 
 * @author Emmanuel Bourg
 * @since 1.0
 */
public class SpcStatementType extends ASN1Object {
    
    private ASN1ObjectIdentifier identifier;

    public SpcStatementType(ASN1ObjectIdentifier identifier) {
        if (!AuthenticodeObjectIdentifiers.SPC_INDIVIDUAL_SP_KEY_PURPOSE_OBJID.equals(identifier)
                && !AuthenticodeObjectIdentifiers.SPC_COMMERCIAL_SP_KEY_PURPOSE_OBJID.equals(identifier)) {
            throw new IllegalArgumentException("Invalid id for SpcStatementType : " + identifier);
        }
        
        this.identifier = identifier;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[] { identifier });
    }
}
