package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Budget.TABLE_NAME)
@AttributeOverrides(value= {
		@AttributeOverride(name=Budget.FIELD_IDENTIFIER,column = @Column(name="UUID"))
		,@AttributeOverride(name=Budget.FIELD_CODE,column = @Column(name="BUD_CODE"))
})
public class Budget extends AbstractIdentifiableBusinessWithTransientAmounts implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_SPECIALIZATION_UNIT) private BudgetSpecializationUnit specializationUnit;
	@ManyToOne @JoinColumn(name = COLUMN_ACT_VERSION) private BudgetaryActVersion actVersion;
	
	@Override
	public Budget setIdentifier(String identifier) {
		return (Budget) super.setIdentifier(identifier);
	}
	
	@Override
	public Budget setCode(String code) {
		return (Budget) super.setCode(code);
	}
	
	public static final String FIELD_SPECIALIZATION_UNIT = "specializationUnit";
	public static final String FIELD_ACT_VERSION = "actVersion";
	
	public static final String COLUMN_SPECIALIZATION_UNIT = "BUD_USB_ID";
	public static final String COLUMN_ACT_VERSION = "BUD_VAB_ID";
	
	public static final String TABLE_NAME = "budget";	
}