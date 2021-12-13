package com.mobius.software.cdr.parser.primitives;
/*
SubscriberEquipmentType ::= ENUMERATED
--
-- It should be noted that depending on the services, not all equipment types are applicable.
-- For IMS equipment types 0 and 3 are applicable.
--
{
 iMEISV (0),
 mAC (1),
 eUI64 (2),
 modifiedEUI64 (3)
} 
*/
/**
 * @author yulian.oifa
 *
 */
public enum SubscriberEquipmentType {
	iMEISV(0), mAC(1), eUI64(2), modifiedEUI64(3);

    private int type;

    private SubscriberEquipmentType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public static SubscriberEquipmentType getInstance(int type) {
        switch (type) {
        	case 0:
            	return SubscriberEquipmentType.iMEISV;
        	case 1:
                return SubscriberEquipmentType.mAC;
            case 2:
                return SubscriberEquipmentType.eUI64;
            case 3:
                return SubscriberEquipmentType.modifiedEUI64;
            default:
                return null;
        }
    }
}
