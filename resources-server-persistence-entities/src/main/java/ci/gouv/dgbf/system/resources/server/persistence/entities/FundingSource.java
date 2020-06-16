package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=FundingSource.TABLE_NAME)
@AttributeOverrides(value = {
		@AttributeOverride(name = FundingSource.FIELD_IDENTIFIER,column = @Column(name="UUID"))
		,@AttributeOverride(name = FundingSource.FIELD_CODE,column = @Column(name="CAT_SRC_CODE"))
		,@AttributeOverride(name = FundingSource.FIELD_NAME,column = @Column(name="CAT_SRC_LIBELLE"))
})
public class FundingSource extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public FundingSource setIdentifier(String identifier) {
		return (FundingSource) super.setIdentifier(identifier);
	}
	
	@Override
	public FundingSource setCode(String code) {
		return (FundingSource) super.setCode(code);
	}
	
	@Override
	public FundingSource setName(String name) {
		return (FundingSource) super.setName(name);
	}
	
	public static final String TABLE_NAME = "SOURCE_FINANCEMENT";
	
	public static final String CODE_TRESOR = "0";
	public static final String CODE_DON = "1";
	public static final String CODE_EMPRUNT = "2";
}