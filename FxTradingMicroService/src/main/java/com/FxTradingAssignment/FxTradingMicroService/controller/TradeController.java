package com.FxTradingAssignment.FxTradingMicroService.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.FxTradingAssignment.FxTradingMicroService.customexception.CustomDatabaseException;
import com.FxTradingAssignment.FxTradingMicroService.model.Trade;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

@RestController
@RequestMapping("/trade")
public class TradeController {

	@PostMapping("/booktrade")
	public String receiveTrade(@RequestBody Trade trade) {
		try {

			java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fxtrading",
					"root", "Ambika@5001");

			String insertQuery = "INSERT INTO trade (tradeNo, currencyPair,customerName, amount,rate) VALUES (?, ?, ?,?,?)";

			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setInt(1, trade.getTradeNo());
			preparedStatement.setString(2, trade.getCurrencyPair());
			preparedStatement.setString(3, trade.getCustomerName());
			preparedStatement.setDouble(4, trade.getAmount());
			preparedStatement.setDouble(5, trade.getRate());

			int rowsAffected = preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();

			if (rowsAffected > 0) {
				trade.bookTrade(trade);
				return trade.printTrade();
			} else {
				return "Failed to insert trade into the database.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error while processing the trade request.";
		}

	}

	@RequestMapping("printtrades")
	List<String> getdata() throws CustomDatabaseException {
		List<String> list = new ArrayList<>();
		try {
			java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fxtrading",
					"root", "Ambika@5001");
			Statement statement = connection.createStatement();
			String query = "select * from trade";
			ResultSet resultset = statement.executeQuery(query);

			ResultSetMetaData metaData = (ResultSetMetaData) resultset.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String columnName = metaData.getColumnName(i);
				System.out.print(columnName + "\t");
			}
			System.out.println();

			while (resultset.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String columnData = resultset.getString(i);
					list.add(columnData);
					System.out.print(columnData + "\t");
				}
				System.out.println();
			}
			resultset.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new CustomDatabaseException("Error while fetching data from the database" + e);
		}

		System.out.println(list);
		return list;
	}
	@GetMapping("/exit")
        public String exit() {
		return "Exiting the application...";
	}
}
