
package com.bugvm.bindings.admob;

import com.bugvm.rt.bro.ValuedEnum;

public enum GADGender implements ValuedEnum {
	Unknown, Male, Female;

	@Override
	public long value () {
		return ordinal();
	}
}
