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

package com.liferay.commerce.machine.learning.internal.forecast.model;

import com.liferay.commerce.machine.learning.forecast.model.AssetCategoryCommerceMLForecast;

/**
 * @author Riccardo Ferrari
 */
public class AssetCategoryCommerceMLForecastImpl
	extends BaseCommerceMLForecastImpl
	implements AssetCategoryCommerceMLForecast {

	@Override
	public long getAssetCategoryId() {
		return _assetCategoryId;
	}

	@Override
	public long getCommerceAccountId() {
		return _commerceAccountId;
	}

	@Override
	public void setAssetCategoryId(long assetCategoryId) {
		_assetCategoryId = assetCategoryId;
	}

	@Override
	public void setCommerceAccountId(long commerceAccountId) {
		_commerceAccountId = commerceAccountId;
	}

	private long _assetCategoryId;
	private long _commerceAccountId;

}