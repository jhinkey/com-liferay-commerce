<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
CommerceOrderEditDisplayContext commerceOrderEditDisplayContext = (CommerceOrderEditDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

SearchContainer<CommerceOrderItem> commerceOrderItemsSearchContainer = commerceOrderEditDisplayContext.getCommerceOrderItemsSearchContainer();

PortletURL portletURL = commerceOrderEditDisplayContext.getCommerceOrderItemsPortletURL();
%>

<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="commerceOrderItems"
>
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-sort
			orderByCol="<%= commerceOrderItemsSearchContainer.getOrderByCol() %>"
			orderByType="<%= commerceOrderItemsSearchContainer.getOrderByType() %>"
			orderColumns="<%= commerceOrderItemsSearchContainer.getOrderableHeaders() %>"
			portletURL="<%= portletURL %>"
		/>

		<li>
			<aui:form action="<%= portletURL %>" method="get" name="fm">
				<liferay-portlet:renderURLParams portletURL="<%= portletURL %>" />

				<liferay-ui:search-form
					page="/order/item_search.jsp"
					servletContext="<%= application %>"
				/>
			</aui:form>
		</li>
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:add-menu
			inline="<%= true %>"
		>
			<liferay-frontend:add-menu-item
				id="addCommerceOrderItem"
				title='<%= LanguageUtil.get(request, "add-item") %>'
				url="javascript:;"
			/>
		</liferay-frontend:add-menu>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button
			href='<%= "javascript:" + renderResponse.getNamespace() + "deleteCommerceOrderItems();" %>'
			icon="times"
			label="delete"
		/>
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<div class="container-fluid-1280">
	<portlet:actionURL name="editCommerceOrderItem" var="editCommerceOrderItemURL" />

	<aui:form action="<%= editCommerceOrderItemURL %>" name="editCommerceOrderItemFm">
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
		<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
		<aui:input name="commerceOrderId" type="hidden" value="<%= commerceOrderEditDisplayContext.getCommerceOrderId() %>" />
		<aui:input name="cpInstanceIds" type="hidden" value="" />
		<aui:input name="deleteCommerceOrderItemIds" type="hidden" />

		<liferay-ui:search-container
			id="commerceOrderItems"
			searchContainer="<%= commerceOrderItemsSearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.commerce.model.CommerceOrderItem"
				escapedModel="<%= true %>"
				keyProperty="commerceOrderItemId"
				modelVar="commerceOrderItem"
			>

				<%
				PortletURL rowURL = renderResponse.createRenderURL();

				rowURL.setParameter("mvcRenderCommandName", "editCommerceOrderItem");
				rowURL.setParameter("redirect", currentURL);
				rowURL.setParameter("commerceOrderId", String.valueOf(commerceOrderItem.getCommerceOrderId()));
				rowURL.setParameter("commerceOrderItemId", String.valueOf(commerceOrderItem.getCommerceOrderItemId()));

				CommerceMoney unitPriceMoney = commerceOrderItem.getUnitPriceMoney();
				CommerceMoney promoPriceMoney = commerceOrderItem.getPromoPriceMoney();
				CommerceMoney discountAmountMoney = commerceOrderItem.getDiscountAmountMoney();
				CommerceMoney finalPriceMoney = commerceOrderItem.getFinalPriceMoney();
				%>

				<liferay-ui:search-container-column-text
					cssClass="important table-cell-content"
					href="<%= rowURL %>"
					property="sku"
				/>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-content"
					name="name"
					value="<%= commerceOrderItem.getName(locale) %>"
				/>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-content"
					name="unit-price"
					value="<%= unitPriceMoney.format(locale) %>"
				/>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-content"
					name="promo-price"
					value="<%= promoPriceMoney.format(locale) %>"
				/>

				<liferay-ui:search-container-column-text
					name="discount"
					value="<%= discountAmountMoney.format(locale) %>"
				/>

				<liferay-ui:search-container-column-text
					property="quantity"
				/>

				<liferay-ui:search-container-column-text
					name="total"
					value="<%= finalPriceMoney.format(locale) %>"
				/>

				<liferay-ui:search-container-column-jsp
					cssClass="entry-action-column"
					path="/order/item_action.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				markupView="lexicon"
			/>
		</liferay-ui:search-container>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />deleteCommerceOrderItems() {
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-the-selected-order-items" />')) {
			var form = AUI.$(document.<portlet:namespace />editCommerceOrderItemFm);

			form.fm('<%= Constants.CMD %>').val('<%= Constants.DELETE %>');
			form.fm('deleteCommerceOrderItemIds').val(Liferay.Util.listCheckedExcept(form, '<portlet:namespace />allRowIds'));

			submitForm(form);
		}
	}
</aui:script>

<aui:script use="liferay-item-selector-dialog">
	$('#<portlet:namespace />addCommerceOrderItem').on(
		'click',
		function(event) {
			event.preventDefault();

			var itemSelectorDialog = new A.LiferayItemSelectorDialog(
				{
					eventName: 'productInstancesSelectItem',
					on: {
						selectedItemChange: function(event) {
							var selectedItems = event.newVal;

							if (selectedItems) {
								$('#<portlet:namespace />cpInstanceIds').val(selectedItems);

								var editCommerceOrderItemFm = $('#<portlet:namespace />editCommerceOrderItemFm');

								submitForm(editCommerceOrderItemFm);
							}
						}
					},
					title: '<liferay-ui:message arguments="<%= commerceOrderEditDisplayContext.getCommerceOrderId() %>" key="add-new-product-to-order-x" />',
					url: '<%= commerceOrderEditDisplayContext.getItemSelectorUrl() %>'
				}
			);

			itemSelectorDialog.open();
		}
	);
</aui:script>