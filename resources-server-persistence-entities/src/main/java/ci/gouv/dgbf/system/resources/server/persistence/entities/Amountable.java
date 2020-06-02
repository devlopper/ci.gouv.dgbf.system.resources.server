package ci.gouv.dgbf.system.resources.server.persistence.entities;

public interface Amountable {

	Amounts getAmounts();
	Amountable setAmounts(Amounts amounts);
	
	default Amounts getAmounts(Boolean injectIfNull) {
		if(getAmounts() == null && Boolean.TRUE.equals(injectIfNull))
			setAmounts(new Amounts());
		return getAmounts();
	}
	

}
