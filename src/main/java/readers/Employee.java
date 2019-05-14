package readers;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class Employee implements CsvObject {
    public Integer recordType;

    public Integer recordNumber;

    public String inboundLastName;

    @Override
    public String toString()
    {
        return "Employee [recordType=" + recordType + ", recordNumber=" + recordNumber + ", inboundLastName=" +
                inboundLastName + "]";
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public ColumnPositionMappingStrategy setColumnMapping()
    {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Employee.class);
        String[] columns = new String[] {"record_type", "record_number", "inbound_last_name"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}