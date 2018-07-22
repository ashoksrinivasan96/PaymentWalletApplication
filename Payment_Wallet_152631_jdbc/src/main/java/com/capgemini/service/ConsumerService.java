package com.capgemini.service;

import com.capgemini.bean.ConsumerDetails;

import com.capgemini.dao.ConsumerDAO;

public class ConsumerService {

	ConsumerDAO consumerDaoObject = new ConsumerDAO();

	public ConsumerDetails createAccount(ConsumerDetails consumerDetailsObject) {

		return consumerDaoObject.createAccount(consumerDetailsObject);

	}
}