// Licensed to the .NET Foundation under one or more agreements.
// The .NET Foundation licenses this

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LivreEmpruntés
{ 
    public class AlreadyExistBookException : Exception
    {
        public AlreadyExistBookException(object key) : base($"Book Already Exist: {key}")
        {
        }
    }
}
