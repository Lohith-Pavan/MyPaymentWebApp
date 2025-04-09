package com.lohith.mypaymentwebapp.model;

import java.util.List;

public class UserDashboardModel {
      private UserProfileModel userProfileModel;
      private List<UserViewBankModel> userViewBankModel;
	public UserProfileModel getUserProfileModel() {
		return userProfileModel;
	}
	public void setUserProfileModel(UserProfileModel userProfileModel) {
		this.userProfileModel = userProfileModel;
	}
	public List<UserViewBankModel> getUserViewBankModel() {
		return userViewBankModel;
	}
	public void setUserViewBankModel(List<UserViewBankModel> userViewBankModel) {
		this.userViewBankModel = userViewBankModel;
	}
}
