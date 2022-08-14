package dbcommon;

import dbcommon.entities.Buyer;
import dbcommon.util.JDBConnector;
import dbcommon.util.SqlReader;
import domain.input.inputData.criteria.BadCustomer;
import domain.input.inputData.criteria.LastNameCriteria;
import domain.input.inputData.criteria.MinMaxExpences;
import domain.input.inputData.criteria.NameProductCountBuy;
import domain.input.outputData.stat.Customer;
import domain.input.outputData.stat.Purchase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private final Statement statement;

    public Repository() {
        try {
            this.statement = JDBConnector.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Buyer> getBuyerByLastName(LastNameCriteria criteria) throws IOException {
        try (ResultSet resultSet = statement.executeQuery(SqlReader.getBuyersByLastName(criteria.getLastName()))) {
            ArrayList<Buyer> buyers = new ArrayList<>();
            while (resultSet.next()) {
                buyers.add(new Buyer(resultSet.getString("lastName"), resultSet.getString("name")));
            }
            return buyers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Buyer> getBuyerByProductNameAndCountPurchase(NameProductCountBuy criteria) throws IOException {
        try (ResultSet resultSet = statement.executeQuery(
                SqlReader.getBuyersBuProductNameAndCountBuy(criteria.getProductName(), criteria.getMinTimes()))) {
            ArrayList<Buyer> buyers = new ArrayList<>();
            while (resultSet.next()) {
                buyers.add(new Buyer(resultSet.getString("lastName"), resultSet.getString("name")));
            }
            return buyers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Buyer> getBadBuyers(BadCustomer criteria) throws IOException {
        try (ResultSet resultSet = statement.executeQuery(
                SqlReader.getBadBuyers(criteria.getBadCustomer()))) {
            ArrayList<Buyer> buyers = new ArrayList<>();
            while (resultSet.next()) {
                buyers.add(new Buyer(resultSet.getString("lastName"), resultSet.getString("name")));
            }
            return buyers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Buyer> getBuyersByMinPriceAndMaxPrice(MinMaxExpences criteria) throws IOException {
        try (ResultSet resultSet = statement.executeQuery(
                SqlReader.getBuyersMyMinPriceMaxPrice(criteria.getMinExpenses(), criteria.getMaxExpenses()))) {
            ArrayList<Buyer> buyers = new ArrayList<>();
            while (resultSet.next()) {
                buyers.add(new Buyer(resultSet.getString("lastName"), resultSet.getString("name")));
            }
            return buyers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getStat(LocalDate startTime, LocalDate endTime) throws IOException {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = null;
        try (ResultSet resultSet = statement.executeQuery(
                SqlReader.getStat(startTime, endTime))) {
            int id = 0;
            while (resultSet.next()) {
                int currentId = resultSet.getInt("identity");
                if (id != currentId) {
                    id = currentId;
                    customer = new Customer(resultSet.getString("b_lastName")
                            + " " + resultSet.getString("b_name"));
                    customers.add(customer);
                }
                customer.getPurchases().add(new Purchase(resultSet.getString("prodname"),
                        resultSet.getDouble("all_price")));
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
