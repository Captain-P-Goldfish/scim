package de.captaingoldfish.scim.sdk.common.resources.complex;

import java.util.Optional;

import de.captaingoldfish.scim.sdk.common.constants.AttributeNames;
import de.captaingoldfish.scim.sdk.common.resources.base.ScimObjectNode;
import lombok.Builder;
import lombok.NoArgsConstructor;


/**
 * author Pascal Knueppel <br>
 * created at: 18.10.2019 - 11:12 <br>
 * <br>
 * A complex type that specifies PATCH configuration options. REQUIRED. See Section 3.5.2 of [RFC7644].
 */
@NoArgsConstructor
public class PatchConfig extends ScimObjectNode
{

  @Builder
  public PatchConfig(Boolean supported,
                     Boolean activateSailsPointWorkaround,
                     Boolean activateMsAzureWorkaround,
                     Boolean activateMsAzureValueSubAttributeWorkaround,
                     Boolean msAzureComplexSimpleValueWorkaroundActive)
  {
    super(null);
    setSupported(supported);
    setActivateSailsPointWorkaround(activateSailsPointWorkaround);
    setMsAzureFilterWorkaroundActive(activateMsAzureWorkaround);
    setMsAzureValueSubAttributeWorkaroundActive(activateMsAzureValueSubAttributeWorkaround);
    setMsAzureComplexSimpleValueWorkaroundActive(msAzureComplexSimpleValueWorkaroundActive);
  }

  /**
   * A Boolean value specifying whether the operation is supported. REQUIRED.
   */
  public boolean isSupported()
  {
    return getBooleanAttribute(AttributeNames.RFC7643.SUPPORTED).orElse(false);
  }

  /**
   * A Boolean value specifying whether the operation is supported. REQUIRED.
   */
  public void setSupported(Boolean supported)
  {
    setAttribute(AttributeNames.RFC7643.SUPPORTED, Optional.ofNullable(supported).orElse(false));
  }

  /**
   * A Workaround to handle patch replace-ops on single complex types as add operations.
   *
   * @see https://github.com/Captain-P-Goldfish/SCIM-SDK/issues/327
   */
  public boolean isActivateSailsPointWorkaround()
  {
    return getBooleanAttribute(AttributeNames.Custom.ACTIVATE_SAILS_POINT_WORKAROUND).orElse(false);
  }

  /**
   * A Workaround to handle patch replace-ops on single complex types as add operations.
   *
   * @see https://github.com/Captain-P-Goldfish/SCIM-SDK/issues/327
   */
  public void setActivateSailsPointWorkaround(Boolean activateSailsPointWorkaround)
  {
    setAttribute(AttributeNames.Custom.ACTIVATE_SAILS_POINT_WORKAROUND, activateSailsPointWorkaround);
  }

  /**
   * A workaround to handle filter-expressions in patch-paths as attributes that will be added to the resource
   *
   * @see https://github.com/Captain-P-Goldfish/SCIM-SDK/issues/416
   * @see de.captaingoldfish.scim.sdk.server.patch.msazure.MsAzurePatchFilterWorkaround
   */
  public boolean isMsAzureFilterWorkaroundActive()
  {
    return getBooleanAttribute(AttributeNames.Custom.ACTIVATE_MS_AZURE_FILTER_WORKAROUND).orElse(false);
  }

  /**
   * A workaround to handle filter-expressions in patch-paths as attributes that will be added to the resource
   *
   * @see https://github.com/Captain-P-Goldfish/SCIM-SDK/issues/416
   * @see de.captaingoldfish.scim.sdk.server.patch.msazure.MsAzurePatchFilterWorkaround
   */
  public void setMsAzureFilterWorkaroundActive(Boolean msAzureWorkaroundActive)
  {
    setAttribute(AttributeNames.Custom.ACTIVATE_MS_AZURE_FILTER_WORKAROUND, msAzureWorkaroundActive);
  }

  /**
   * A workaround to handle MsAzures illegal value-subattribute notation
   *
   * @see https://github.com/Captain-P-Goldfish/SCIM-SDK/issues/516
   * @see de.captaingoldfish.scim.sdk.server.patch.msazure.MsAzurePatchValueSubAttributeRebuilder
   */
  public boolean isMsAzureValueSubAttributeWorkaroundActive()
  {
    return getBooleanAttribute(AttributeNames.Custom.ACTIVATE_MS_AZURE_VALUE_SUB_ATTRIBUTE_WORKAROUND).orElse(false);
  }

  /**
   * A workaround to handle MsAzures illegal value-subattribute notation
   *
   * @see https://github.com/Captain-P-Goldfish/SCIM-SDK/issues/516
   * @see de.captaingoldfish.scim.sdk.server.patch.msazure.MsAzurePatchValueSubAttributeRebuilder
   */
  public void setMsAzureValueSubAttributeWorkaroundActive(Boolean msAzureValueSubAttributeWorkaroundActive)
  {
    setAttribute(AttributeNames.Custom.ACTIVATE_MS_AZURE_VALUE_SUB_ATTRIBUTE_WORKAROUND,
                 msAzureValueSubAttributeWorkaroundActive);
  }

  /**
   * A workaround to handle MsAzures illegal complex-simple-value notation.
   *
   * @see https://github.com/Captain-P-Goldfish/SCIM-SDK/issues/541
   * @see de.captaingoldfish.scim.sdk.server.patch.msazure.MsAzurePatchComplexValueRebuilder
   */
  public boolean isMsAzureComplexSimpleValueWorkaroundActive()
  {
    return getBooleanAttribute(AttributeNames.Custom.ACTIVATE_MS_AZURE_COMPLEX_SIMPLE_VALUE_WORKAROUND).orElse(false);
  }

  /**
   * A workaround to handle MsAzures illegal complex-simple-value notation.
   *
   * @see https://github.com/Captain-P-Goldfish/SCIM-SDK/issues/541
   * @see de.captaingoldfish.scim.sdk.server.patch.msazure.MsAzurePatchComplexValueRebuilder
   */
  public void setMsAzureComplexSimpleValueWorkaroundActive(Boolean msAzureComplexSimpleValueWorkaroundActive)
  {
    setAttribute(AttributeNames.Custom.ACTIVATE_MS_AZURE_COMPLEX_SIMPLE_VALUE_WORKAROUND,
                 msAzureComplexSimpleValueWorkaroundActive);
  }

  /**
   * override lombok builder with public constructor
   */
  public static class PatchConfigBuilder
  {

    public PatchConfigBuilder()
    {}
  }
}
