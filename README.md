# Esports-Data
GUI Retrieves live Esports League and Series data from the PandaScore API and sends it to a configured number using the Twilio API.

## INSTRUCTIONS
#### Before Launch:
- User must have a valid PandaScore and Twilio Account.
- Edit Input Token.txt file in resources folder and replace token with your own PandaScore token in one line.
- Edit Output Token.txt file in resources folder and replace each token with your own Twilio tokens, each type per line.
    - Line 1: SID
    - Line 2: Auth
    - Line 3: "To" Number (Personal)
    - Line 3: "From" Number (Twilio)

#### Run:
- Application can either use an online or simulated offline version of both API's in any combination by replacing argument variables with either "online" or "offline.
- 1st Argument: PandaScore API.
- 2nd Argument: Twilio API.
- Launch Application Type: gradle run --args="online online"

#### Test:
- Test Applications Type: gradle test