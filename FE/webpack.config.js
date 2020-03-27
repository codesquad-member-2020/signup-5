const path = require('path');

module.exports = {
    mode: "development",
    entry: "./src/js/signup/signupMain.js",
    output: {
        path: path.resolve("./src/js", "dist"),
        filename: "signup.bundle.js",
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                use: 'babel-loader',
                exclude: /node_modules/
            }
        ]
    }
}