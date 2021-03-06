package soot.jimple.interproc.ifds.flowfunc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import soot.jimple.interproc.ifds.FlowFunction;

/**
 * Function that creates a new value (e.g. returns a set containing a fixed value when given
 * a specific parameter), but acts like the identity function for all other parameters.
 *
 * @param <D> The type of data-flow facts to be computed by the tabulation problem.
 */
public class Gen<D> implements FlowFunction<D> {
	
	private final D genValue;
	private final D zeroValue;
	
	public Gen(D genValue, D zeroValue){
		assert genValue != null;
		assert zeroValue != null;
		
		this.genValue = genValue;
		this.zeroValue = zeroValue;
	} 

	public Set<D> computeTargets(D source) {
		if (source.equals(zeroValue)) {
			HashSet<D> res = new HashSet<D>();
			res.add(source);
			res.add(genValue);
			return res;
		} else
			return Collections.singleton(source);
	}
	
}