#EXEMPLO#############################################################
# {
#        "name": "Google",
#        "location":
#                {
#                        "street": "1600 Amphitheatre Parkway",
#                        "city": "Mountain View",
#                        "state": "California",
#                        "country": "US"
#                },
#        "employees":
#                [
#                        {
#                                "name": "Michael",
#                                "division": "Engineering"
#                        },
#                        {
#                                "name": "Laura",
#                                "division": "HR"
#                        },
#                        {
#                                "name": "Elise",
#                                "division": "Marketing"
#                        }
#                ]
#}

####################################################################

#wget http://stedolan.github.io/jq/download/linux32/jq (32-bit system)
wget http://stedolan.github.io/jq/download/linux64/jq (64-bit system)
chmod +x ./jq
sudo cp jq /usr/bin

#####################################################################

#Print to console
cat json.txt

#To parse a JSON object:
cat json.txt | jq '.name'

#To parse a nested JSON object:
cat json.txt | jq '.location.city'

#To parse a JSON array:
cat json.txt | jq '.employees[0].name'

#To extract specific fields from a JSON object:
cat json.txt | jq '.location | {street, city}'


