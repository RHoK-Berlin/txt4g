Text 4 good (txt4g) is a application intended to bring information to mobile devices. 
Its main focus lies in making vital information easily available to people living in regions without widespread internet use. 
Information can be provided by organizations working for the public like hospitals, NGOs and government agencies. 
This information is channeled to subscribers over the GSM-based SMS service widely available on mobile phones.

SETUP:
txt4g is optimaly deployed using the heroku.com PaaS provider, which offers its services free of charge for the first 750 h of processor time. 
Because txt4g is a application based on standard RoR and Java its also possible to deploy the application to other cloud services or even host it on own infrastructure with minimal changes.
command to start the 'middleware' (java): heroku scale tick=1