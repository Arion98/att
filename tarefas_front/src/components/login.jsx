import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from './AuthProvider';
import 'bootstrap/dist/css/bootstrap.min.css';
import { api } from "../config_axios";

const FormularioLogin = () => {
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const { login } = useAuth();
    const navigate = useNavigate();


        const handleSubmit = async (e) => {
            e.preventDefault();
    
            if (email.trim() === "" || senha.trim() === "") {
                alert("Preencha todos os campos!");
                return;
            }
    
            try {
                const response = await api.post("/login", { email, senha });
                if (response.status === 200) {
                    login();
                    navigate('/welcome');
                } else {
                    alert("Usuário ou senha inválidos!");
                }
            } catch (error) {
                alert("Email ou senha inválida, tente novamente!");
            }
        };
    

    return (
        <section className="vh-100">
            <div className="container py-5 h-100">
                <div className="row d-flex align-items-center justify-content-center h-100">
                    <div className="col-md-8 col-lg-7 col-xl-6">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg" className="img-fluid" alt="Phone image"/>
                    </div>
                    <div className="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                        <form onSubmit={handleSubmit}>
                            <div className="form-outline mb-4">
                                <label className="form-label" htmlFor="email">Email:</label>
                                <input type="email" id="email" className="form-control form-control-lg" value={email} onChange={(e) => setEmail(e.target.value)} />
                            </div>
                            <div className="form-outline mb-4">
                                <label className="form-label" htmlFor="senha">Senha:</label>
                                <input type="password" id="senha" className="form-control form-control-lg" value={senha} onChange={(e) => setSenha(e.target.value)} />
                            </div>
                            <button type="submit" className="btn btn-primary btn-lg btn-block">Login</button>
                            <div>
                                <br />
                                <Link to="/user" className="nav-link">
                                    <button type="button" className="btn btn-primary btn-lg btn-block">Cadastrar-se</button>
                                </Link>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    );
};

export default FormularioLogin;
