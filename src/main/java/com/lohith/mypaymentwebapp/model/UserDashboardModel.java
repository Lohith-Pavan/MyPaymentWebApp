package com.lohith.mypaymentwebapp.model;

import java.util.ArrayList;
import java.util.List;

public class UserDashboardModel {
      private UserProfileModel userProfileModel;
      private List<UserViewBankModel> userBanksListModel;
      private List<UserViewTransactionsModel> userTxnListModel;
	public UserProfileModel getUserProfileModel() {
		return userProfileModel;
	}
	public void setUserProfileModel(UserProfileModel userProfileModel) {
		this.userProfileModel = userProfileModel;
	}
	public List<UserViewBankModel> getUserBanksListModel() {
		return userBanksListModel;
	}
	public void setUserBanksListModel(List<UserViewBankModel> userBanksListModel) {
		this.userBanksListModel = userBanksListModel;
	}
	public List<UserViewTransactionsModel> getUserTxnListModel() {
		return userTxnListModel;
	}
	public void setUserTxnListModel(List<UserViewTransactionsModel> userTxnListModel) {
		this.userTxnListModel = userTxnListModel;
	}
}
