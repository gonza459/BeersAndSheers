from faker import Faker
import csv

faker = Faker()

def writeToCSV():
    with open(fileName, 'w') as csvfile:
        fieldnames = ['Client_fName', 'Client_lName', 'C_phoneNum', 'email', 'C_street_address', 'C_city', 'C_zipcode',
                      'creditCardNum','cardExpiration', 'cardCode', 'Employee_fName', 'Employee_lName', 'E_phoneNum',
                      'E_street_address', 'E_city', 'E_zipcode', 'HairColor', 'NextAppointment', 'ServiceID']

        writer = csv.DictWriter(csvfile, fieldnames = fieldnames)

        writer.writeheader()
        for i in range(int(numTuples)):
            writer.writerow(
                {   #Client Information
                    'Client_fName': faker.first_name(),             #Client table
                    'Client_lName': faker.last_name(),
                    'C_phoneNum': faker.phone_number(),
                    'email': faker.email(),
                    'C_street_address': faker.street_address(),        #Client/ Address table
                    'C_city': faker.city(),
                    'C_zipcode': faker.zipcode(),
                    'creditCardNum': faker.credit_card_number(),        #Finance table
                    'cardExpiration': faker.credit_card_expire(),
                    'cardCode': faker.credit_card_security_code(),

                    #Employee Information
                    'Employee_fName': faker.first_name(),           #Employee table
                    'Employee_lName': faker.last_name(),
                    'E_phoneNum': faker.phone_number(),
                    'E_street_address': faker.street_address(),     #Address/ employee table
                    'E_city': faker.city(),
                    'E_zipcode': faker.zipcode(),

                    #Salon Services
                    'HairColor': faker.color_name(),                #Appointments
                    'NextAppointment': faker.date(pattern="%Y-%m-%d", end_datetime="-10y"),     #Clients/Appointment table
                    'ServiceID': faker.ean8()
               }
            )

if __name__ == '__main__':
    fileName = input('Enter the name of the file you want to create: ')
    fileName = fileName + '.csv'
    numTuples = input('Enter the number of tuples you would like: ')
    writeToCSV()

