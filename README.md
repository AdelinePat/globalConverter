# globalConverter
## Numeric Base Conversion & Caesar Cipher
GlobalConverter is a Java console application that allows users to:
- Convert strings into various numeric bases (binary, octal, decimal, hexadecimal)
- Reverse the conversion back into text
- Encrypt and decrypt messages using the Caesar Cipher algorithm

This project was developed as part of a school assignment focused on string manipulation, number base conversions,
input handling and basic cryptography

## Features
- **Base conversions:**
  - Binary
  - Octal
  - Decimal (ASCII)
  - Hexadecimal
    
    All can reverse the process
- **Caesar Cipher** 
  - Encrypt messages by shifting letters by a user-defined key
  - Option to decrypt using reverse shift
- **Interactive Console Menu**
  - User input is cleaned and validated
  - Terminal-based UI with clear instructions and ANSI-colored feedback
- **Error Handling**
  - Handles user input errors via custom `UserError` exceptions
  - Handles unexpected algorithm issues via `AlgorithmError`
  - Color-coded output for better UX
  
## Project Structure
``` src/
├── main/                 # Main class and program entry point
├── converters/           # Classes for each numeric base conversion
├── converter_factory/    # Factory to select the correct converter
├── user_interface/       # Menu view and controller logic
├── utils/                # Input cleaning, ASCII utilities, parsing
├── caesar/               # Caesar cipher implementation
├── custom_exceptions/    # Custom error type
```
## Project team

This project was developed collaboratively as part of a school assignment
- [Jolyne Mangeot](https://github.com/jolyne-mangeot) :
  - Implemented octal base conversion 
  - Developed the Caesar cipher module
  - Created the initial menu interface
  - Added ANSI-colored console feedback
- [Florence Navet](https://github.com/Florence-Navet) :
  - Implemented hexadecimal base conversion
  - Co-designed the project architecture and class diagram
  - Participated in class diagram design
- [Adeline Patenne](https://github.com/AdelinePat) :
  - Implemented binary and decimal base conversions
  - Co-designed and implemented the project architecture (packages, interface, structure)
  - Handled input cleaning, parsing, and error management 
  - Refactored and consolidated code for maintainability