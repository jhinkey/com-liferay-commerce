/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.headless.commerce.admin.pricing.internal.resource.v1_0;

import com.liferay.headless.commerce.admin.pricing.dto.v1_0.DiscountRule;
import com.liferay.headless.commerce.admin.pricing.resource.v1_0.DiscountRuleResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseDiscountRuleResourceImpl
	implements DiscountRuleResource {

	@Override
	@GET
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "externalReferenceCode"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path(
		"/discount/by-externalReferenceCode/{externalReferenceCode}/discountRules/"
	)
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "DiscountRule")})
	public Page<DiscountRule>
			getDiscountByExternalReferenceCodeDiscountRulesPage(
				@NotNull @Parameter(hidden = true)
				@PathParam("externalReferenceCode") String
					externalReferenceCode,
				@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@POST
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "externalReferenceCode")
		}
	)
	@Path(
		"/discount/by-externalReferenceCode/{externalReferenceCode}/discountRules/"
	)
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "DiscountRule")})
	public DiscountRule postDiscountByExternalReferenceCodeDiscountRule(
			@NotNull @Parameter(hidden = true)
			@PathParam("externalReferenceCode") String externalReferenceCode,
			DiscountRule discountRule)
		throws Exception {

		return new DiscountRule();
	}

	@Override
	@DELETE
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "id")})
	@Path("/discountRules/{id}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "DiscountRule")})
	public Response deleteDiscountRule(
			@NotNull @Parameter(hidden = true) @PathParam("id") Long id)
		throws Exception {

		Response.ResponseBuilder responseBuilder = Response.ok();

		return responseBuilder.build();
	}

	@Override
	@GET
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "id")})
	@Path("/discountRules/{id}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "DiscountRule")})
	public DiscountRule getDiscountRule(
			@NotNull @Parameter(hidden = true) @PathParam("id") Long id)
		throws Exception {

		return new DiscountRule();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@PATCH
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "id")})
	@Path("/discountRules/{id}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "DiscountRule")})
	public Response patchDiscountRule(
			@NotNull @Parameter(hidden = true) @PathParam("id") Long id,
			DiscountRule discountRule)
		throws Exception {

		Response.ResponseBuilder responseBuilder = Response.ok();

		return responseBuilder.build();
	}

	@Override
	@GET
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "id"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/discounts/{id}/discountRules/")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "DiscountRule")})
	public Page<DiscountRule> getDiscountIdDiscountRulesPage(
			@NotNull @Parameter(hidden = true) @PathParam("id") Long id,
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@POST
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "id")})
	@Path("/discounts/{id}/discountRules/")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "DiscountRule")})
	public DiscountRule postDiscountIdDiscountRule(
			@NotNull @Parameter(hidden = true) @PathParam("id") Long id,
			DiscountRule discountRule)
		throws Exception {

		return new DiscountRule();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(
		DiscountRule discountRule, DiscountRule existingDiscountRule) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}