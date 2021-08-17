package com.sjh.model;

public class MembersVO {
	private String mId;
	private String mPw;
	private String mName;
	private int mNo;
	private int mDeptno;
	private String mPhone;
	private String mEmail;
	

public MembersVO() {
	
}


public MembersVO(String mId, String mPw, String mName, int mNo, int mDeptno, String mPhone, String mEmail) {
	super();
	this.mId = mId;
	this.mPw = mPw;
	this.mName = mName;
	this.mNo = mNo;
	this.mDeptno = mDeptno;
	this.mPhone = mPhone;
	this.mEmail = mEmail;
}


public String getmId() {
	return mId;
}


public void setmId(String mId) {
	this.mId = mId;
}


public String getmPw() {
	return mPw;
}


public void setmPw(String mPw) {
	this.mPw = mPw;
}


public String getmName() {
	return mName;
}


public void setmName(String mName) {
	this.mName = mName;
}


public int getmNo() {
	return mNo;
}


public void setmNo(int mNo) {
	this.mNo = mNo;
}


public int getmDeptno() {
	return mDeptno;
}


public void setmDeptno(int mDeptno) {
	this.mDeptno = mDeptno;
}


public String getmPhone() {
	return mPhone;
}


public void setmPhone(String mPhone) {
	this.mPhone = mPhone;
}


public String getmEmail() {
	return mEmail;
}


public void setmEmail(String mEmail) {
	this.mEmail = mEmail;
}


@Override
public String toString() {
	return "MembersVO [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mNo=" + mNo + ", mDeptno=" + mDeptno
			+ ", mPhone=" + mPhone + ", mEmail=" + mEmail + "]";
}






}

