
package org.robovm.bindings.admob;

import org.robovm.rt.bro.ValuedEnum;

public enum GADGender implements ValuedEnum {
	Unknown, Male, Female;

	@Override
	public long value () {
		return ordinal();
	}
}
