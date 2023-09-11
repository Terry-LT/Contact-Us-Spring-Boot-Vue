<template>
    
<div id="contact_us">
    <div class="alert alert-warning" role="alert" v-if="error_message">
        {{ error_message }}
    </div>
    <form>
        <legend>Contact Us Form</legend>
        <div class="mb-3">
            <label for="emailInput">Email</label>
            <input v-model="email" type="email" 
            id="emailInput" class="form-control">
        </div>
        <div class="mb-3">
            <label for="subjectInput">Subject</label>
            <input v-model="subject" 
            type="text" id="subjectInput" class="form-control">
        </div>
        <div class="input-group mb-3">
            <label for="phoneNumberInput">Phone Number</label>
            <span class="input-group-text" id="basic-addon1">+</span>
            <input v-model="phoneNumber" 
            type="number" id="phoneNumberInput" class="form-control">
        </div>
        <div class="mb-3">
            <label for="bodyInput">Body</label>
            <textarea v-model="body" 
            class="form-control" id="bodyInput" cols="30" rows="10"></textarea>
        </div>
        <div class="mb-3">
            <button @click="sendEmail" class="btn btn-primary" type="button">Send</button>
        </div>
    </form>
</div>
</template>
<script>
import axios from 'axios'
export default {
    data:function(){
        return {
            email:"",
            subject:"",
            phoneNumber:"",
            body:"",
            error_message:null
        };
    },

    methods:{
        setToastMessage:function(){
            let el = document.getElementById('toast_success');
            el.classList.add('show');
        },
        setErrorMessage:function(message){
            //Set error message
            this.error_message = message;
        },
        sendEmail:function(){
            
            const formData = {
                "from":this.email,
                "subject":this.subject,
                "phoneNumber":this.phoneNumber,
                "body":this.body,
            }
            let setErrorMessage = this.setErrorMessage;
            let setToastMessage = this.setToastMessage;
            console.log(formData);
            axios({
                method:'post',
                url:'http://localhost:8080/api/v1/contactUs',
                data:formData
            })
            .then(response => {
                console.log(response.data.data);
                setErrorMessage(null);
                setToastMessage();
            })
            .catch(function(error){
                //Set error message
                setErrorMessage(error.response.data);

                console.log(error.response.data.error);
                console.log(error.response.data.message);
                console.log(error.response.data.status);
            });
        }
    }
}
</script>